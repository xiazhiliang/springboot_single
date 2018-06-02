package com.fly.caipiao.comment.service.impl;

import com.fly.caipiao.comment.dao.UserElasticsearchRepository;
import com.fly.caipiao.comment.entity.UserEsEntity;
import com.fly.caipiao.comment.service.EsTestService;
import com.fly.caipiao.comment.web.vo.UserVO;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author baidu
 * @date 2018/5/29 上午2:58
 * @description ${TODO}
 **/

@Service("esTestService")
public class EsTestServiceImpl implements EsTestService {
    @Autowired
    private ElasticsearchTemplate template;
    @Autowired
    private UserElasticsearchRepository repository;

    @Override
    public void add(UserEsEntity entity) {
        repository.save(entity);
    }

    @Override
    public List<UserVO> listConditionMatch() {
        MatchQueryBuilder builder = QueryBuilders.matchQuery("lastName","smith");
        SearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(builder).build();
        List<UserEsEntity> list = repository.search(query).getContent();
        return list.stream().map(item-> new UserVO(item)).collect(Collectors.toList());
    }

    @Override
    public List<UserVO> listConditionPhraseMatch(Pageable pageable) {
        MatchPhraseQueryBuilder builder = QueryBuilders.matchPhraseQuery("about","rock climbing");
        SearchQuery query = new NativeSearchQueryBuilder().
                withQuery(builder).
                withPageable(pageable).
                        build();
        List<UserEsEntity>  list = repository.search(query).getContent();

        return list.stream().map(item-> new UserVO(item)).collect(Collectors.toList());
    }

    @Override
    public List<UserVO> listConditionPhraseMatchHighlight() {
        MatchPhraseQueryBuilder builder = QueryBuilders.matchPhraseQuery("about","rock climbing");
        SearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(builder).
                        withHighlightFields(new HighlightBuilder.Field("about")).
                        build();
        AggregatedPage<UserVO> page = template.queryForPage(query, UserVO.class, new SearchResultMapper() {
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
                List<UserVO> chunk = new ArrayList<>();
                for (SearchHit searchHit : searchResponse.getHits()) {
                    if (searchResponse.getHits().getHits().length <= 0) {
                        return null;
                    }
                    UserVO user = new UserVO();
                    user.setId(Long.valueOf(searchHit.getId()));
                    user.setInterests((List<String>) searchHit.getSource().get("interests"));
                    user.setFirstName((String) searchHit.getSource().get("firstName"));
                    user.setLastName((String) searchHit.getSource().get("lastName"));
                    user.setAge((Integer) searchHit.getSource().get("age"));
                    user.setAbout(searchHit.getHighlightFields().get("about").fragments()[0].toString());
                    chunk.add(user);
                }
                if (chunk.size() > 0) {
                    if (chunk.size() > 0) {
                        return new AggregatedPageImpl<T>((List<T>) chunk);
                    }
                }
                return null;
            }
        });
        return page.getContent();
    }

    @Override
    public List<UserVO> listConditionBool() {
        BoolQueryBuilder builder = QueryBuilders.boolQuery().
                must(QueryBuilders.matchQuery("lastName","smith")).
                must(QueryBuilders.rangeQuery("age").gt(30));
        SearchQuery query = new NativeSearchQueryBuilder().
                withQuery(builder).build();
        Iterable<UserEsEntity>  iterable = repository.search(query);
        List<UserEsEntity> list = new ArrayList<>();
        Iterator<UserEsEntity> iterator = iterable.iterator();
        while (iterator.hasNext())
        {
            list.add(iterator.next());
        }
        return list.stream().map(item-> new UserVO(item)).collect(Collectors.toList());
    }

    @Override
    public List<UserVO> listConditions() {
        MatchQueryBuilder builder = QueryBuilders.matchQuery("lastName","smith");
//        List<SortBuilder> sorts = SortBuilder.buildSort();
        RangeQueryBuilder filter = QueryBuilders.rangeQuery("age").gt(30);
        SearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(builder)
                .withQuery(filter)
                .withHighlightFields(new HighlightBuilder.Field("about"))
                .build();
        HighlightBuilder.Field field = new HighlightBuilder.Field("about");
        Iterable<UserEsEntity>  iterable = repository.search(query);
        List<UserEsEntity> list = new ArrayList<>();
        Iterator<UserEsEntity> iterator = iterable.iterator();
        while (iterator.hasNext())
        {
            list.add(iterator.next());
        }
        return list.stream().map(item-> new UserVO(item)).collect(Collectors.toList());
    }
}

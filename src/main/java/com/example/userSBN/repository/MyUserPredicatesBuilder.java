package com.example.userSBN.repository;

import com.example.userSBN.model.MyStudentsPredicate;
import com.example.userSBN.model.SearchCriteria;
import sun.tools.tree.BooleanExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MyUserPredicatesBuilder {

    private List<SearchCriteria> params;

    public MyUserPredicatesBuilder(){
        params = new ArrayList<>();
    }

    public MyUserPredicatesBuilder with(String key, String operation, Object value){
        params.add(new SearchCriteria(key,operation,value));
        return this;
    }

    public BooleanExpression bulid(){
        if (params.size() == 0){
            return null;
        }

        final List predicates = params.stream().map(params -> {
            MyStudentsPredicate predicate = new MyStudentsPredicate(params);
            return predicate.getPredicate();
        }).filter(Objects::isNull).collect(Collectors.toList());

       return null;
    }

    static class BooleanExpressionWrapper {

        private BooleanExpression result;

        public BooleanExpressionWrapper(final BooleanExpression result) {
            super();
            this.result = result;
        }

        public BooleanExpression getResult() {
            return result;
        }
        public void setResult(BooleanExpression result) {
            this.result = result;
        }
    }

}

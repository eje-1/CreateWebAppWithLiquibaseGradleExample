package com.example.userSBN.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFaecher is a Querydsl query type for Faecher
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFaecher extends EntityPathBase<Faecher> {

    private static final long serialVersionUID = -1904521588L;

    public static final QFaecher faecher = new QFaecher("faecher");

    public final StringPath abkuerzung = createString("abkuerzung");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final SetPath<User, QUser> student = this.<User, QUser>createSet("student", User.class, QUser.class, PathInits.DIRECT2);

    public final StringPath stufe = createString("stufe");

    public QFaecher(String variable) {
        super(Faecher.class, forVariable(variable));
    }

    public QFaecher(Path<? extends Faecher> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFaecher(PathMetadata metadata) {
        super(Faecher.class, metadata);
    }

}


package com.example.userSBN.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1418664677L;

    public static final QUser user = new QUser("user");

    public final StringPath birthday = createString("birthday");

    public final ListPath<Faecher, QFaecher> courses = this.<Faecher, QFaecher>createList("courses", Faecher.class, QFaecher.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath ort = createString("ort");

    public final StringPath plz = createString("plz");

    public final StringPath sex = createString("sex");

    public final StringPath spitzname = createString("spitzname");

    public final StringPath strasse = createString("strasse");

    public final StringPath telefon = createString("telefon");

    public final StringPath vorname = createString("vorname");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}


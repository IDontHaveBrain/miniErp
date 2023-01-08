package minierp.web.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QApproval is a Querydsl query type for Approval
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QApproval extends EntityPathBase<Approval> {

    private static final long serialVersionUID = -657303488L;

    public static final QApproval approval = new QApproval("approval");

    public final NumberPath<Long> approvalId = createNumber("approvalId", Long.class);

    public final StringPath process = createString("process");

    public QApproval(String variable) {
        super(Approval.class, forVariable(variable));
    }

    public QApproval(Path<? extends Approval> path) {
        super(path.getType(), path.getMetadata());
    }

    public QApproval(PathMetadata metadata) {
        super(Approval.class, metadata);
    }

}


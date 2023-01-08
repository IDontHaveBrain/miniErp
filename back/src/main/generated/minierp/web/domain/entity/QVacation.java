package minierp.web.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVacation is a Querydsl query type for Vacation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVacation extends EntityPathBase<Vacation> {

    private static final long serialVersionUID = 766579930L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVacation vacation = new QVacation("vacation");

    public final QApproval approvalId;

    public final DatePath<java.time.LocalDate> endDate = createDate("endDate", java.time.LocalDate.class);

    public final minierp.web.domain.entity.member.QMember memberId;

    public final DatePath<java.time.LocalDate> startDate = createDate("startDate", java.time.LocalDate.class);

    public final StringPath useDay = createString("useDay");

    public final NumberPath<Long> vacationId = createNumber("vacationId", Long.class);

    public QVacation(String variable) {
        this(Vacation.class, forVariable(variable), INITS);
    }

    public QVacation(Path<? extends Vacation> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVacation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVacation(PathMetadata metadata, PathInits inits) {
        this(Vacation.class, metadata, inits);
    }

    public QVacation(Class<? extends Vacation> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.approvalId = inits.isInitialized("approvalId") ? new QApproval(forProperty("approvalId")) : null;
        this.memberId = inits.isInitialized("memberId") ? new minierp.web.domain.entity.member.QMember(forProperty("memberId")) : null;
    }

}


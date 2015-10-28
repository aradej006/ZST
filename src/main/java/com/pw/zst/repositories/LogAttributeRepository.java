package com.pw.zst.repositories;

        import com.pw.zst.entities.LogAttribute;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

/**
 * Created by aradej on 2015-10-28.
 */
@Repository
public interface LogAttributeRepository extends JpaRepository<LogAttribute, Long> {

}

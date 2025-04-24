package br.com.awsservices.aws_services.repository;

import br.com.awsservices.aws_services.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(
        final String status
    );

}
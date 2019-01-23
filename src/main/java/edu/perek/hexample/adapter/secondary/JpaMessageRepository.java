package edu.perek.hexample.adapter.secondary;

import edu.perek.hexample.adapter.secondary.model.JPAMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaMessageRepository extends JpaRepository<JPAMessage, UUID> {
}

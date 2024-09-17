package com.swsa.repository;
import com.swsa.domain.Card;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {
}

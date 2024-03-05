package bg.softuni.workshopPathfinder.repository;

import bg.softuni.workshopPathfinder.model.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    @Query("select r from Route as r Order by size(r.comments) desc limit 1")
    Route findMostCommented();

}

package bg.softuni.workshopPathfinder.service.Impl;

import bg.softuni.workshopPathfinder.model.entity.Route;
import bg.softuni.workshopPathfinder.repository.RouteRepository;
import bg.softuni.workshopPathfinder.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl implements RouteService {

    private RouteRepository repository;


    @Autowired
    public RouteServiceImpl(RouteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Route getMostCommented() {
        return this.repository.findMostCommented();
    }
}

package springapiapp.weatherproject.services.springdatajpa;

import org.springframework.stereotype.Service;
import springapiapp.weatherproject.model.ConvertedRoot;
import springapiapp.weatherproject.repositories.RootRepository;
import springapiapp.weatherproject.services.RootService;

import java.util.HashSet;
import java.util.Set;

@Service
public class RootSDJpaService implements RootService {

    private final RootRepository rootRepository;

    public RootSDJpaService(RootRepository rootRepository) {
        this.rootRepository = rootRepository;
    }


    @Override
    public ConvertedRoot save(ConvertedRoot convertedRoot) {
        return rootRepository.save(convertedRoot);
    }

    @Override
    public void delete(ConvertedRoot convertedRoot) {
        rootRepository.delete(convertedRoot);
    }

    @Override
    public void deleteById(Long id) {
        rootRepository.deleteById(id);
    }

    @Override
    public Set<ConvertedRoot> findAll() {
        Set<ConvertedRoot> roots = new HashSet<>();
        rootRepository.findAll().forEach(roots::add);
        return roots;
    }

    @Override
    public ConvertedRoot findById(Long id) {
        return rootRepository.findById(id).orElse(null);
    }
}

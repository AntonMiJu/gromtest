package lesson35.service;

import lesson35.model.GeneralClass;
import lesson35.repository.GeneralRepository;

public class GeneralService<T extends GeneralClass> {
    private GeneralRepository<T> generalRepository = new GeneralRepository<>();

    public T findObjectById(long id){
        T[] objects = (T[]) generalRepository.readFile().toArray();
        for (T el : objects){
            if (el.getId() == id)
                return el;
        }
        return null;
    }
}

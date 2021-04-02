package fr.davidrobin.api.repository;

import org.springframework.data.repository.CrudRepository;

import fr.davidrobin.api.entity.Folder;

public interface FolderRepository extends CrudRepository<Folder, Long> {

}

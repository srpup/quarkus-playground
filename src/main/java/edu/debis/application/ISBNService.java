package edu.debis.application;

import edu.debis.dto.ISBN;

import javax.validation.constraints.NotNull;
import java.util.Collection;

public interface ISBNService {

    Collection<ISBN> getAll();

    ISBN getDetails(String code);
}

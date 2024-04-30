package core;

import java.util.List;

public interface OfferDao {
    List<OfferType> getAllOfferTypes() throws Exception;
}
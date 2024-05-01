package core;

import java.util.List;

public interface OfferDao {
    List<Offer> getAllOffers() throws Exception;
}
package core;

import java.util.List;

public interface PropertyReviews_Dao {
    List<PropertyReviews> getAllPropertyReviews() throws Exception;
    void addPropertyReview(PropertyReviews review) throws Exception;
}

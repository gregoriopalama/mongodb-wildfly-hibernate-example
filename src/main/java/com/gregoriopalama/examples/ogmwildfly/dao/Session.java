package com.gregoriopalama.examples.ogmwildfly.dao;

import javax.persistence.Embeddable;
import java.util.Date;

/**
 * Created by gregorio on 24/08/16.
 */
@Embeddable
public class Session {
    private Date startDate;
    private Date endDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

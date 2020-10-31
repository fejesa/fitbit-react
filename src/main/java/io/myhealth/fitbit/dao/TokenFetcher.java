package io.myhealth.fitbit.dao;

public interface TokenFetcher {

    /**
     * Refreshes the Fitbit tokens.
     */
    void refreshToken();
}

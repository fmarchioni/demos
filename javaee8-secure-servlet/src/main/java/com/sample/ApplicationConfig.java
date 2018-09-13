package com.sample;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

// Database Definition for built-in DatabaseIdentityStore
@DatabaseIdentityStoreDefinition(dataSourceLookup = "java:/MySqlDS", callerQuery = "select password from USERS where login=?", groupsQuery = "select role, 'Roles' from USERS where login=?", hashAlgorithm = Pbkdf2PasswordHash.class, priorityExpression = "#{100}", hashAlgorithmParameters = {
        "Pbkdf2PasswordHash.Iterations=3072", "${applicationConfig.dyna}" })

@ApplicationScoped
@Named
public class ApplicationConfig {

    public String[] getDyna() {
        return new String[] { "Pbkdf2PasswordHash.Algorithm=PBKDF2WithHmacSHA256",
                "Pbkdf2PasswordHash.SaltSizeBytes=64" };
    }

}
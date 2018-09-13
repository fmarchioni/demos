package com.sample;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.identitystore.*;

@DatabaseIdentityStoreDefinition(dataSourceLookup = "java:/MySqlDS", callerQuery = "select password from USERS where login=?", groupsQuery = "select role, 'Roles' from USERS where login=?", priority = 30)
@ApplicationScoped

public class BeanConfig {
}

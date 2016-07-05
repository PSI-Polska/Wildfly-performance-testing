package pl.psi.wildfly_performance_testing.dao;

import pl.psi.wildfly_performance_testing.model.small.Address;

import javax.ejb.Stateless;

/**
 * Created by mblaszyk on 2016-07-05.
 */
@Stateless
public class AddressDao extends GenericDao<Address> {
    public AddressDao() {
        super(Address.class);
    }
}

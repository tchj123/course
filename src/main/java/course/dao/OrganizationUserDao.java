
package course.dao;

import course.bean.OrganizationUser;

public interface OrganizationUserDao
{
	
	public OrganizationUser findByUserName(String userName);

	public boolean updateUser(OrganizationUser user);

	public int register(OrganizationUser userInfo);

}

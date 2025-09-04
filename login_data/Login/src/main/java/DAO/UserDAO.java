package DAO;

import Model.User;

public interface UserDAO {
	User get(String username);
	void resetPassword(String username, String newPassword);
}

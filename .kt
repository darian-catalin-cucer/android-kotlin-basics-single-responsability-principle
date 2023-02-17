// Example of Single Responsibility Principle in Kotlin

class UserRepository(private val db: Database) {
    
    // function to add a new user to the database
    fun addUser(user: User) {
        db.insertUser(user)
    }
    
    // function to get a user from the database by id
    fun getUserById(userId: String): User {
        return db.getUserById(userId)
    }
    
    // function to update an existing user in the database
    fun updateUser(user: User) {
        db.updateUser(user)
    }
    
    // function to delete a user from the database
    fun deleteUser(userId: String) {
        db.deleteUser(userId)
    }
}

class UserController(private val userRepository: UserRepository) {
    
    // function to handle user registration
    fun registerUser(name: String, email: String, password: String) {
        val user = User(name, email, password)
        userRepository.addUser(user)
    }
    
    // function to handle user login
    fun loginUser(email: String, password: String): User? {
        val user = userRepository.getUserByEmail(email)
        if (user != null && user.password == password) {
            return user
        }
        return null
    }
    
    // function to handle user profile updates
    fun updateProfile(user: User) {
        userRepository.updateUser(user)
    }
    
    // function to handle user account deletion
    fun deleteAccount(userId: String) {
        userRepository.deleteUser(userId)
    }
}

class test {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();

        ReadWriteUser.load(); //Loads users

        userManager.addUser("Test User", "Elliot", "Ross");
        userManager.addUser("Mike/32131", "Mike", "Mad");
        userManager.addUser("Tim412", "Tim", "Smith");
    }
}

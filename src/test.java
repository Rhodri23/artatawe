class test {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();

        ReadWriteUser.load(); //Loads users

        boolean user = userManager.addUser("Test User", "Elliot", "Ross");
        user = userManager.addUser("Mike32131", "Mike", "Mad");
        user = userManager.addUser("Tim412", "Tim", "Smith");
    }
}

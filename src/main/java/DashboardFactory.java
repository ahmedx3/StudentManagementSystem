public class DashboardFactory {
    public Dashboard getDashboard(String dashboardType) {
        if (dashboardType == null) {
            return null;
        }
        if (dashboardType.equalsIgnoreCase("ADMIN")) {
            return new AdminDashboard();
        } else if (dashboardType.equalsIgnoreCase("TEACHER")) {
            return new TeacherDashboard();
        } else if (dashboardType.equalsIgnoreCase("STUDENT")) {
            return new StudentDashboard();
        }
        return null;
    }
}

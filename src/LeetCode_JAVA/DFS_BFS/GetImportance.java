package LeetCode_JAVA.DFS_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/employee-importance/
 */

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
};

public class GetImportance {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, 5, new ArrayList<>(Arrays.asList(2, 3))));
        employees.add(new Employee(2, 3, new ArrayList<>()));
        employees.add(new Employee(3, 3, new ArrayList<>()));
        System.out.println(new GetImportance().getImportance(employees, 1));
    }

    HashMap<Integer, Employee> map = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(id);
    }

    public int dfs(int id) {
        Employee employee = map.get(id);
        int total = employee.importance;
        List<Integer> subordinates = employee.subordinates;
        for (int subId : subordinates) {
            total += dfs(subId);
        }
        return total;
    }

}

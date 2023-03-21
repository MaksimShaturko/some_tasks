package io.ylab.shaturko.task3.org_structure.impl;

import io.ylab.shaturko.task3.org_structure.Employee;
import io.ylab.shaturko.task3.org_structure.OrgStructureParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class OrgStructureParserImpl implements OrgStructureParser {
    @Override
    public Employee parseStructure(File csvFile) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(csvFile));

        // Мапа всех Employee <id, Employee>
        Map<Long, Employee> map = new HashMap<>();

        // Лист всех Employee, для которых не было босса, во время парсинга файла employees?
        // т.к. босс оказался ниже по строкам, нежели подчиненный
        List<Employee> employeesWaitingForBoss = new ArrayList<>();
        Employee mainBoss = null;

        // Пропускаем первую строку с названиями полей
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String[] fields = scanner.nextLine().split(";");

            // создаем объект и сразу заполняем то, что явно известно:
            // id, name, position
            Employee employee = new Employee();
            Long id = Long.valueOf(fields[0]);
            employee.setId(id);
            employee.setName(fields[2]);
            employee.setPosition(fields[3]);

            // Если это не Генеральный, то у него boss_id пустое,
            // забираем его и пишем в объект,.
            // Если boss_id не пустое, то это Генеральный и мы присваиваем объект ссылке mainBoss
            // которую мы в итоге возвращаем в результатае работы метода
            if (fields[1] != "") {
                Long bossId = Long.valueOf(fields[1]);
                employee.setBossId(bossId);

                // Проверяем, есть ли в мапе Employee с таким id, как boss_id текущего Employee
                // Если есть, то задаем объект босса из мапы данному Employee
                if (map.containsKey(bossId)) {
                    Employee boss = map.get(bossId);
                    employee.setBoss(boss);
                    boss.getSubordinates().add(employee);
                    // Если нет, то кладем данного employee в List, где все employees без объекта своего босса
                } else {
                    employeesWaitingForBoss.add(employee);
                }
            } else {
                mainBoss = employee;
            }
            // Кладем в мапу данного Employee
            map.put(id, employee);
        }
        // Проходим по всем Employee без объекта босса и задаем его
        for (Employee employee: employeesWaitingForBoss) {
            employee.setBoss(map.get(employee.getBossId()));
            employee.getBoss().getSubordinates().add(employee);
        }

        scanner.close();

        return mainBoss;
    }
}

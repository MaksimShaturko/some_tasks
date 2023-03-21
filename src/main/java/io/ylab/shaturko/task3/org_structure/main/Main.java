package io.ylab.shaturko.task3.org_structure.main;

import io.ylab.shaturko.task3.org_structure.Employee;
import io.ylab.shaturko.task3.org_structure.OrgStructureParser;
import io.ylab.shaturko.task3.org_structure.impl.OrgStructureParserImpl;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        OrgStructureParser parser = new OrgStructureParserImpl();
        Employee boss = parser.parseStructure(new File("src/main/resources/employees.csv"));
        //Выводя Директора на консоль, видим всю иерархию организации
        System.out.println(boss);

        //Видим , что вторая в списке подчиненных - гл. бух, поэтому можем посмотреть ее подчиненного
        System.out.println(boss.getSubordinates().get(1).getSubordinates().get(0));
        System.out.println(boss.getSubordinates().get(1).getSubordinates().get(0).getBoss());
    }
}

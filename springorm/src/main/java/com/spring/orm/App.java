package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//        Student student = new Student(101,"Prakash","Aarha district");
//        int res = studentDao.insert(student);
//        System.out.println(res);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean go = true;
		while (go) {
			System.out.println("1 - add");
			System.out.println("2 - display all objects");
			System.out.println("3 - Get single object");
			System.out.println("4 - delete");
			System.out.println("5 - update");
			System.out.println("6 - exit");

			try {

				int input = Integer.parseInt(br.readLine());

				switch (input) {
				case 1:
					System.out.println("Enter user id");
					int uid = Integer.parseInt(br.readLine());

					System.out.println("Enter user name");
					String uname = br.readLine();

					System.out.println("Enter user city");
					String ucity = br.readLine();

					Student s = new Student(uid, uname, ucity);
					int insert = studentDao.insert(s);
					System.out.println("Number of users added : " + insert);
					break;

				case 2:
					List<Student> allStudent = studentDao.getAllStudent();
					for (Student slist : allStudent) {
						System.out.println(slist.getId()+ " "+ slist.getName()+" "+slist.getCity());
					}
					break;

				case 3:
					System.out.println("Enter user id to get data");
					int uid1=Integer.parseInt(br.readLine());
					studentDao.getStudent(uid1);
					break;

				case 4:
					System.out.println("Enter user id to get data");
					int uid2=Integer.parseInt(br.readLine());
					studentDao.deleteStudent(uid2);
					break;

				case 5:
					break;

				case 6:
//				System.exit(0);
					go = false;
					break;

				default:
					System.out.println("!!!!INVALID!!!!");
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Invalid input");
				System.out.println(e.getMessage());
			}

		}

	}
}

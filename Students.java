import java.sql.*;
import java.sql.Date;
import java.util.*;
public class Students
{	
	static Connection con;
	static Statement st;
    static PreparedStatement ps;
static void connection()
{
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root","Shalim@143@#");
	 st=con.createStatement();
    }
	catch(Exception e)
	{
		System.out.println("Entry is invalid"+e);
	}
}
	static void insert(int n,String nm,String db,String dj)
	{
		try
		{
            boolean flag=false;
            ps=con.prepareStatement("insert into student (student_no,student_name,student_dob,student_doj) values(?,?,?,?)");
            ps.setInt(1, n);
            ps.setString(2,nm);
            ps.setDate(3,Date.valueOf(db));
            ps.setDate(4,Date.valueOf(dj));	
            ps.executeUpdate();
            flag=true;	
		if(flag)
			System.out.println("Successsful");
		else
			System.out.println("Unauccessful"); 
		}
		catch(Exception e)
		{
			System.out.println("Entry is invalid"+e);
		} 
}
	static void update(int no,String name,String db,String dj)
	{
		try
		{
            boolean flag=false;
            ps=con.prepareStatement("update student set student_name=?,student_dob=?,student_doj=? where student_no=?");
            ps.setString(2,name);
            ps.setDate(3,Date.valueOf(db));
            ps.setDate(4,Date.valueOf(dj));	
            ps.executeUpdate();
            flag=true;	
		if(flag)
			System.out.println("Successsful");
		else
			System.out.println("Unauccessful"); 
		}
		catch(Exception e)
		{
			System.out.println("Entry is invalid"+e);
		} 
    }
	static void delete(int dl)
	{
		try
		{
            boolean flag=false;
            ps=con.prepareStatement("delete from student where student_no="+dl+"");
            ps.executeUpdate();
            flag=true;	
		if(flag)
			System.out.println("Successsful");
		else
			System.out.println("Unauccessful"); 
		}
		catch(Exception e)
		{
			System.out.println("Entry is invalid"+e);
		}
	}
		static void list()
		{
			try
			{
            ps=con.prepareStatement("select *from student");
			ResultSet rs=ps.executeQuery();
			System.out.println("Student_No    Student_Name      Student_DOB      Student_DoJ");
			System.out.println("_____________________________________________________________\n");
			while(rs.next())
			{
			int no=rs.getInt("student_no");
			String name=rs.getString("student_name");
            Date dob=rs.getDate("student_dob");
            Date doj=rs.getDate("student_doj");
				
		   System.out.println(no+"            "+name+"             "+dob+ "            "+doj);
				
			}
			}
			catch(Exception e)
			{
				System.out.println("Entry is invalid"+e);
			}	
	     }
		static void search(int s)
		{
		try
		{
        ps=con.prepareStatement("select *from student where student_no="+s+"");
		ResultSet rs=ps.executeQuery();
		System.out.println("Student_No    Student_Name      Student_DOB      Student_DoJ");
		System.out.println("____________________________________________________________");
		while(rs.next())
		{
		int no=rs.getInt("student_no");
		String name=rs.getString("student_name");
		Date dob=rs.getDate("student_dob");
		Date doj=rs.getDate("student_doj");
	    System.out.println(no+"             "+name+"          "+dob+ "            "+doj);
		}
		}
		catch(Exception e)
		{
			System.out.println("Entry is invalid"+e);
		}	
		}
		
public static void main(String[]args)
{ 
	
	connection();
	Scanner i=new Scanner(System.in);
	int ch=1;

	
	while(ch!=0)
	{
		System.out.println("_____________________________________________________\n");
		System.out.println("1.Insert   2.Update    3.Delete   4.Lists   5.Search");
		System.out.println("_____________________________________________________");
		System.out.print("Enter your choice  :");
		 
		ch=i.nextInt();
	switch(ch)
	{
	case 1:
        System.out.print("Student_No :");
        int n=i.nextInt();
        System.out.print("Student_Name :");
        String n1=i.next();
        System.out.print("Student_Dob :");
        String n2=i.next();
        System.out.print("Student_Doj :");
        String n3=i.next();
		insert(n,n1,n2,n3);
		break;
	case 2:
	    System.out.print("Student_No :");
		int no=i.nextInt();
		System.out.print("Student_Name :");
	    String name=i.next();
	    System.out.print("Student_Dob :");
	    String dob=i.next();
	    System.out.print("Student_Doj :");
	    String doj=i.next();
        update(no,name,dob,doj);
		break;
	case 3:
		System.out.print("Student_No :");
	    int d=i.nextInt();
		delete(d);
		break;
	case 4:
		list();
		break;
	case 5:
		System.out.print("Student_No :");
	    int s=i.nextInt();
		search(s);
		break;
		//exist(0);
	}
	}
}
}


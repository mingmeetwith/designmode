package game.demo;

import java.util.HashSet;

public class Demo3 {
	static class Student{
	    private String name;
	    private int age;

	    public Student() {
	    }

	    public Student(String name, int age) {
	        this.name = name;
	        this.age = age;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getAge() {
	        return age;
	    }

	    @Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + age;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Student other = (Student) obj;
			if (age != other.age)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
	}
	
	public static void main(String[] args) {
        HashSet<Student> hs = new HashSet<>();

        hs.add(new Student("a", 1));
        hs.add(new Student("a", 1));
        hs.add(new Student("ab", 1));

        for (Student s :
                hs) {
            System.out.println(s.getName() + " : " + s.getAge());
        }
    }
}

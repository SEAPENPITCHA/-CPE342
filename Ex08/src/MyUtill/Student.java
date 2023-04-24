package MyUtil;

    public class Student {
       String id;
       String fn;
       String ln;
       double gpa;

      public Student(String id, String fn, String ln, double gpa){
    	  
          this.id = id;
          this.fn = fn;
          this.ln = ln;
          this.gpa = gpa;
      }
    
      public String getID() {
         return id;
      }

      public String getFirstName() {
        return fn;
      }

      public String getLastName() {
        return ln;
      }

      public double getGPA() {
        return gpa;
      }

      public String toString()
      {
    	  
        return "ID:"+id+"Name:"+fn
                +ln+"GPA:"+gpa 
                ;
      }
      
       public int compareTo(Student o) {
           return Integer.parseInt(this.id) -Integer.parseInt(o.id);
           
      }
}

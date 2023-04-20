public class Account{
    public String name;
    public String description;
    public String vidno;
    public String likes;
    public String title;

    public Account(String line){

        String[] accLine = line.split(" ",2);
        if(accLine.length == 1){
            this.name = accLine[0];
            this.description = "No Description";
        }
        //else if(accLine.length ==
        else{
            this.name = accLine[0];
            this.description = accLine[1];
        }

    }

    public int compareTo(Account a){
        return this.name.compareTo(a.name);
    }

    public void addPosts(String line){


        String[] postLine = line.split(" ",4);

        this.name = postLine[0];
        this.vidno= postLine[1];
        this.likes = postLine[2];
        this.title = postLine[3];

    }


    public Object getName() {
        return name;
    }
}


// public deletePosts(String lin){

//  }




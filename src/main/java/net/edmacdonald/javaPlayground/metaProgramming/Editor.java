package net.edmacdonald.javaPlayground.metaProgramming;

public class Editor {

    StringBuffer book = new StringBuffer();

    public void takeInputFrom(Scientist aScientist, Mathematician aMathematician, Engineer anEngineer){
        book = new StringBuffer();

        book.append("\nMy Book\n");
        book.append("By: Isaac Newton\n");

        book.append("First I created a theory: " + aScientist.createATheory());
        book.append("\n");
        book.append("Then I constrained the problem: " + aMathematician.constrainAProblem());
        book.append("\n");
        book.append("Then I built something: " + anEngineer.buildSomething());
        book.append("\n");

    }

    public String ghostWrite(){
        return book.toString();
    }
}

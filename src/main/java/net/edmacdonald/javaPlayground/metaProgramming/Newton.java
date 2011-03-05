package net.edmacdonald.javaPlayground.metaProgramming;

public class Newton implements Engineer, Mathematician, Scientist{
    private Editor editor = new Editor();

    @Override
    public String writeBook() {
        editor.takeInputFrom(this, this, this);
        return editor.ghostWrite();
    }

    @Override
    public String buildSomething() {
        return "Look! a paper airplane. Okay, back to work";
    }

    @Override
    public String constrainAProblem() {
        return  "During acceleration, velocity varies from instant to instant (derivative). "   +
                "An accumulation of these instants yields distance (integration)";
    }

    @Override
    public String createATheory() {
        return "All things on earth are attracted to it, and it to them";
    }
}

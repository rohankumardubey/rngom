package org.kohsuke.rngom.dump;

import org.kohsuke.rngom.ast.builder.Annotations;
import org.kohsuke.rngom.ast.builder.BuildException;
import org.kohsuke.rngom.ast.builder.CommentList;
import org.kohsuke.rngom.ast.builder.Div;
import org.kohsuke.rngom.ast.builder.Grammar;
import org.kohsuke.rngom.ast.builder.Include;
import org.kohsuke.rngom.ast.om.Location;
import org.kohsuke.rngom.ast.om.ParsedElementAnnotation;
import org.kohsuke.rngom.ast.om.ParsedPattern;
import org.kohsuke.rngom.parse.IllegalSchemaException;
import org.kohsuke.rngom.parse.Parseable;

/**
 * 
 * @author
 *      Kohsuke Kawaguchi (kk@kohsuke.org)
 */
public class GrammarImpl extends Base implements Grammar,Div,Include {
    public GrammarImpl(Factory f, Printer p, int id) {
        super(f, p, id);
    }

    protected String prefix() {
        return "g";
    }

    public ParsedPattern endGrammar(Location loc, Annotations anno) throws BuildException {
        out("endGrammar").param(loc).param(anno);
        return printer.result(factory.createPattern());
    }

    public void define(String name, Combine combine, ParsedPattern pattern, Location loc, Annotations anno) throws BuildException {
        out("define").param(name).param(combine).param(pattern).param(loc).param(anno).result();
    }

    public void topLevelAnnotation(ParsedElementAnnotation ea) throws BuildException {
        out("topLevelAnnotation").param(ea).result();
    }

    public void topLevelComment(CommentList comments) throws BuildException {
        out("topLevelComment").param(comments).result();
    }

    public Div makeDiv() {
        out("makeDiv");
        return printer.result(factory.createDiv(printer));
    }

    public Include makeInclude() {
        out("makeInclude");
        return printer.result(factory.createInclude(printer));
    }

    public ParsedPattern makeParentRef(String name, Location loc, Annotations anno) throws BuildException {
        out("makeParentRef").param(name).param(loc).param(anno);
        return printer.result(factory.createPattern());
    }

    public ParsedPattern makeRef(String name, Location loc, Annotations anno) throws BuildException {
        out("makeRef").param(name).param(loc).param(anno);
        return printer.result(factory.createPattern());
    }

    public void endDiv(Location loc, Annotations anno) throws BuildException {
        out("endDiv").param(loc).param(anno).result();
    }

    public void endInclude(Parseable current, String uri, String ns, Location loc, Annotations anno) throws BuildException, IllegalSchemaException {
        out("endInclude").param(uri).param(ns).param(loc).param(anno).result();
    }
}

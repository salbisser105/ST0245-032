/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class BinaryTree {
    public static void main(String[] args){
        Node yo= new Node("Juan Pablo");
        Node papa= new Node("Alvaro");
        Node mama= new Node("Margarita");
        yo.left= mama;
        yo.right= papa;
        
        Node abuelam=new Node("Leonor");
        Node abuelom= new Node("Benjamin");
        Node abuelap= new Node("Carmen");
        Node abuelop= new Node("Abdon");
        mama.right= abuelom;
        mama.left= abuelam;
        papa.right= abuelop;
        papa.left= abuelap;
        
        
        Node mamabuelop= new Node("");
        Node mamabuelap= new Node("");
        Node papabuelop= new Node("");
        Node papabuelap= new Node("Raimundo");
        Node mamabuelom= new Node("Encarnacion");
        Node mamabuelam= new Node("Enriqueta");
        Node papabuelam= new Node("");
        
        abuelop.right= papabuelop;
        abuelop.left=mamabuelop;
        abuelap.right= papabuelap;
        abuelap.left = mamabuelap;
        abuelom.right= papabuelom;
        abuelom.left=mamabuelom;
        abuelam.right= papabuelam;
        abuelam.left = mamabuelam;
    }
}

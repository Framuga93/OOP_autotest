package service;

import familyTree.FamilyTree;
import familyTree.FamilyTreeItem;
import human.Gender;
import human.Human;

public class Service {
    private  FamilyTree<FamilyTreeItem> tree;
    public Service() {
        this.tree = new FamilyTree<>();
    }

    public void addItemToTree(FamilyTreeItem item){
        tree.addTreeItem(item);
    }

    public FamilyTreeItem getItemById(long id){
        return tree.getById(id);
    }

    public void removeItem(long id){
        tree.remove(id);
    }




    public String getHumanListInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Список людей: \n");
        for (FamilyTreeItem item : tree){
            sb.append(item);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName(){
        tree.sortByName();
    }

    public void sortByAge(){
        tree.sortByAge();
    }

    public void sortByGender(){
        tree.sortByGender();
    }

    public FamilyTree<FamilyTreeItem> testTree(){
        Human marya = new Human("Мария", Gender.FEMALE,"2000-03-12");
        Human prohor = new Human("Прохор",Gender.MALE, "1999-06-21");
        tree.addTreeItem(marya);
        tree.addTreeItem(prohor);
        tree.setWedding(marya,prohor);

        Human boris = new Human("Борис",Gender.MALE,
                "2018-07-23", marya,prohor);
        Human olesia = new Human("Олеся",Gender.FEMALE,
                "2020-12-05", marya,prohor);
        tree.addTreeItem(boris);
        tree.addTreeItem(olesia);

        Human pavel = new Human("Павел",Gender.MALE,"1968-07-23");
        pavel.addChild(prohor);
        tree.addTreeItem(pavel);

        return tree;
    }
}

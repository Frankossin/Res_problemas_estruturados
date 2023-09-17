package com.hanoigame;

public class Game {
    private int size;
    private int moves;
    private Stack[] towers;

    public void show() {
        for (int i = 0; i < 3; i++) {
            this.towers[i].show();
        }
    }

    public Stack[] getTowers() {
        return towers;
    }

    public int getMoves() {
        return this.moves;
    }

    public void move(int from, int to) {
        Node removed = this.towers[from].pop();
        this.towers[to].push(removed.getValue());
        this.moves++;
    }

    public Stack getTower(int pos) {
        if (pos >= 3) {
            System.out.println("getTower() wrong value: " + pos);
            return null;
        }
        return this.towers[pos];
    }

    public boolean ascending() {
        for (Stack tower : this.towers) {
            if (tower.full() && tower.ascending()) {
                return true;
            }
        }

        return false;
    }

    public boolean descending() {
        for (Stack tower : this.towers) {
            if (tower.full() && tower.descending()) {
                return true;
            }
        }

        return false;
    }

    public void solveAsc() {
        // Move todos para a primeira torre
        while (this.towers[1].count() != 0) {
            this.move(1, 0);
        }
        while (this.getTower(2).count() != 0) {
            this.move(2, 0);
        }

        this.move(0, 1);
        while (!this.ascending()) {
            if (this.towers[0].getTopValue() < this.towers[1].getTopValue()) {
                this.move(0, 1);
                continue;
            }

            while (this.towers[1].count() != 0) {
                if(this.towers[0].getTopValue() < this.towers[1].getTopValue()) {
                    break;
                }
                this.move(1, 2);
            }
            this.move(0, 1);
            while (this.towers[2].count() != 0) {
                this.move(2, 1);
            }
        }
    }

    public void solveDes() {
        // Move todos para a primeira torre
        while (this.towers[1].count() != 0) {
            this.move(1, 0);
        }
        while (this.getTower(2).count() != 0) {
            this.move(2, 0);
        }

        this.move(0, 1);
        while (!this.descending()) {
            if (this.towers[0].getTopValue() > this.towers[1].getTopValue()) {
                this.move(0, 1);
                continue;
            }

            while (this.towers[1].count() != 0) {
                if(this.towers[0].getTopValue() > this.towers[1].getTopValue()) {
                    break;
                }
                this.move(1, 2);
            }
            this.move(0, 1);
            while (this.towers[2].count() != 0) {
                this.move(2, 1);
            }
        }
    }

    public Game(int size) {
        this.size = size;
        this.moves = 0;
        this.towers = new Stack[3];
        for (int i = 0; i < 3; i++) {
            this.towers[i] = new Stack("Tower " + (char) ('A' + i), size);
        }
        for (int i = 0; i < size; i++) {
            this.towers[0].push(1 + (int) (Math.random() * 100));
        }
    }
}


package com.mycompany.homer;

public class ListaDupla {
    private Celula primeira;
    private Celula ultima;
    private int totalDeElementos = 0;

    private boolean posicaoOcupada(int pos) {
        return pos >= 0 && pos < totalDeElementos;
    }

    private Celula pegaCelula(int pos) {
        if (!posicaoOcupada(pos)) {
            throw new IllegalArgumentException("Posição não existe");
        }

        Celula atual = primeira;
        for (int i = 0; i < pos; i++) {
            atual = atual.getProxima();
        }

        return atual;
    }

    public Object pega(int pos) {
        return pegaCelula(pos).getElemento();
    }
 public void adicionaNoComeco(Object elemento) {
        if (totalDeElementos == 0) {
            Celula nova = new Celula(elemento);
            primeira = nova;
            ultima = nova;
        } else {
            Celula nova = new Celula(primeira, elemento);
            primeira.setAnterior(nova);
            primeira = nova;
        }

        totalDeElementos++;
    }

    public void adiciona(Object elemento) {
        if (totalDeElementos == 0) {
            adicionaNoComeco(elemento);
        } else {
            Celula nova = new Celula(elemento);
            ultima.setProxima(nova);
            nova.setAnterior(ultima);
            ultima = nova;
            totalDeElementos++;
        }
    }

    public void adiciona(int pos, Object elemento) {
        if (pos == 0) {
            adicionaNoComeco(elemento);
        } else if (pos == totalDeElementos) {
            adiciona(elemento);
        } else {
            Celula anterior = pegaCelula(pos - 1);
            Celula proxima = anterior.getProxima();
            Celula nova = new Celula(proxima, elemento);
            nova.setAnterior(anterior);
            anterior.setProxima(nova);
            proxima.setAnterior(nova);
            totalDeElementos++;
        }
    }

    public void removeDoComeco() {
        if (!posicaoOcupada(0)) {
            throw new IllegalArgumentException("Posição não existe");
        }

        primeira = primeira.getProxima();
        totalDeElementos--;

        if (totalDeElementos == 0) {
            ultima = null;
        } else {
            primeira.setAnterior(null);
        }
    }

    public void remove(int pos) {
    if (pos < 0 || pos >= size) {
        throw new IndexOutOfBoundsException("Posição inválida");
    }

    Node curr = head;

    if (pos == 0) {
        head = curr.getNext();
    } else {
        Node prev = null;

        for (int i = 0; i < pos; i++) {
            prev = curr;
            curr = curr.getNext();
        }

        prev.setNext(curr.getNext());
    }

    size--;
}
}

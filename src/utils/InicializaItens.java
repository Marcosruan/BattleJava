package utils;

import jogo.Loja;
import personagens.Heroi;
import itens.pocao.mana.PocaoManaG;
import itens.pocao.mana.PocaoManaM;
import itens.pocao.mana.PocaoManaP;
import itens.pocao.vida.PocaoVidaG;
import itens.pocao.vida.PocaoVidaM;
import itens.pocao.vida.PocaoVidaP;
import itens.runa.armadura.RunaArmaduraG;
import itens.runa.armadura.RunaArmaduraM;
import itens.runa.armadura.RunaArmaduraP;
import itens.runa.chanceCritico.RunaChanceCriticoG;
import itens.runa.chanceCritico.RunaChanceCriticoM;
import itens.runa.chanceCritico.RunaChanceCriticoP;
import itens.runa.dano.RunaDanoG;
import itens.runa.dano.RunaDanoM;
import itens.runa.dano.RunaDanoP;
import itens.runa.especial.ChanceCriticoMax;
import itens.runa.especial.Critico3x;
import itens.runa.especial.DobraDano;
import itens.runa.especial.DobraDanoEspecial;
import itens.runa.especial.DobraMoeda;
import itens.runa.especial.DobraVida;
import itens.runa.mana.RunaManaG;
import itens.runa.mana.RunaManaM;
import itens.runa.mana.RunaManaP;
import itens.runa.manaRegen.RunaManaRegenG;
import itens.runa.manaRegen.RunaManaRegenM;
import itens.runa.manaRegen.RunaManaRegenP;
import itens.runa.vida.RunaVidaG;
import itens.runa.vida.RunaVidaM;
import itens.runa.vida.RunaVidaP;

public class InicializaItens {
	public InicializaItens() {
		setarItensComuns();
		setarItensRaros();
		setarItensEpicos();
		setarItensLendarios();
	}
	
	private void setarItensLendarios() {
		Loja.lendarios.add(new ChanceCriticoMax());
		Loja.lendarios.add(new Critico3x());
		Loja.lendarios.add(new DobraDano());
		Loja.lendarios.add(new DobraDanoEspecial());
		Loja.lendarios.add(new DobraMoeda());
		Loja.lendarios.add(new DobraVida());
		
		Heroi.itens.add(new ChanceCriticoMax());
		Heroi.itens.add(new Critico3x());
		Heroi.itens.add(new DobraDano());
		Heroi.itens.add(new DobraDanoEspecial());
		Heroi.itens.add(new DobraMoeda());
		Heroi.itens.add(new DobraVida());
	}

	private void setarItensEpicos() {
		Loja.epicos.add(new PocaoVidaG());
		Loja.epicos.add(new PocaoManaG());
		Loja.epicos.add(new RunaVidaG());
		Loja.epicos.add(new RunaDanoG());
		Loja.epicos.add(new RunaArmaduraG());
		Loja.epicos.add(new RunaManaG());
		Loja.epicos.add(new RunaManaRegenG());
		Loja.epicos.add(new RunaChanceCriticoG());
		
		Heroi.itens.add(new PocaoVidaG());
		Heroi.itens.add(new PocaoManaG());
		Heroi.itens.add(new RunaVidaG());
		Heroi.itens.add(new RunaDanoG());
		Heroi.itens.add(new RunaArmaduraG());
		Heroi.itens.add(new RunaManaG());
		Heroi.itens.add(new RunaManaRegenG());
		Heroi.itens.add(new RunaChanceCriticoG());
		
	}

	private void setarItensRaros() {
		Loja.raros.add(new PocaoVidaM());
		Loja.raros.add(new PocaoManaM());
		Loja.raros.add(new RunaVidaM());
		Loja.raros.add(new RunaDanoM());
		Loja.raros.add(new RunaArmaduraM());
		Loja.raros.add(new RunaManaM());
		Loja.raros.add(new RunaManaRegenM());
		Loja.raros.add(new RunaChanceCriticoM());
		
		Heroi.itens.add(new PocaoVidaM());
		Heroi.itens.add(new PocaoManaM());
		Heroi.itens.add(new RunaVidaM());
		Heroi.itens.add(new RunaDanoM());
		Heroi.itens.add(new RunaArmaduraM());
		Heroi.itens.add(new RunaManaM());
		Heroi.itens.add(new RunaManaRegenM());
		Heroi.itens.add(new RunaChanceCriticoM());
	}

	private void setarItensComuns() {
		Loja.comuns.add(new PocaoVidaP());
		Loja.comuns.add(new PocaoManaP());
		Loja.comuns.add(new RunaVidaP());
		Loja.comuns.add(new RunaDanoP());
		Loja.comuns.add(new RunaArmaduraP());
		Loja.comuns.add(new RunaManaP());
		Loja.comuns.add(new RunaManaRegenP());
		Loja.comuns.add(new RunaChanceCriticoP());
		
		Heroi.itens.add(new PocaoVidaP());
		Heroi.itens.add(new PocaoManaP());
		Heroi.itens.add(new RunaVidaP());
		Heroi.itens.add(new RunaDanoP());
		Heroi.itens.add(new RunaArmaduraP());
		Heroi.itens.add(new RunaManaP());
		Heroi.itens.add(new RunaManaRegenP());
		Heroi.itens.add(new RunaChanceCriticoP());
	}
}

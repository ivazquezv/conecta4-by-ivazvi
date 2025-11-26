# 🎮 Conecta4 by Iván Vázquez

Proyecto educativo y técnico para implementar el clásico juego **Conecta4** en Java, con soporte para:
- 👤 Humano vs Humano
- 🤖 Humano vs IA
- 🤖 vs 🤖 IA 

Incluye arquitectura modular, renderizado en consola con colores ANSI y estrategias de IA basadas en **Minimax** y **Random**.

---

## 🚀 Características principales
- Tablero de 6x7 con representación visual en consola.
- Controlador (`GameController`) que gestiona turnos, reglas y flujo de partida.
- Vista en consola (`TerminalView`) con renderizado en colores ANSI.
- Jugadores humanos e IA (`Player`) con soporte para distintas estrategias.
- IA configurable:
  - `RandomStrategy`: movimientos aleatorios.
  - `MinimaxStrategy`: búsqueda recursiva con heurística y aleatorización en empates.
- Fábrica de jugadores (`PlayerFactory`) para simplificar la creación de humanos e IA.
- Motor de reglas (`RuleEngine`) para detectar victorias y empates.

---

## 📂 Estructura del proyecto
# Estructura del proyecto

- **model/**
  - Board
  - Cell
  - Player
  - *DiscColor* (enum)
  - Move
  - *GameResult* (enum)

- **rules/**
  - WinRule
  - HorizontalWinRule
  - VerticalWinRule
  - DiagonalWinRule
  - RuleEngine

- **controller/**
  - GameController
  - *Command* (interfaz)
  - DropDiscCommand (comando concreto)
  - CommandHistory (undo/redo)

- **view/**
  - TerminalView
  - Renderer

- **ai/**
  - *Strategy* (interfaz)
  - RandomStrategy
  - MinimaxStrategy

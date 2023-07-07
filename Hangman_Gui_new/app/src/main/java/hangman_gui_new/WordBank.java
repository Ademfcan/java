package hangman_gui_new;

import java.util.concurrent.ThreadLocalRandom;

public class WordBank {
    private static String[] level1 = 
        {"Cat", "Dog", "Ball", "Happy", "Smile",
        "Sun", "Tree", "Blue", "Book", "Chair",
        "Sing", "Jump", "Baby", "Flower", "Friend",
        "Sleep", "Apple", "Cake", "Train", "Game",
        "Dance", "Hat", "Milk", "Beach", "Candy",
        "Ocean", "Laugh", "Park", "Teddy", "Song",
        "Car", "School", "Fish", "Moon", "Star",
        "Horse", "Banana", "Bird", "Island", "Mouse",
        "Key", "Pizza", "Clock", "Boat", "Elephant",
        "Music", "Rain", "House", "Chair", "Light"};
    private static String[] level2 = {
        "Elephant", "Rainbow", "Camera", "Butterfly", "Guitar",
        "Mountain", "Pillow", "Soccer", "Lemon", "Cookie",
        "Dragon", "Telescope", "Ice Cream", "Forest", "Puzzle",
        "Astronaut", "Universe", "Bicycle", "Pizza", "Dolphin",
        "Chocolate", "Balloon", "Robot", "Jellyfish", "Cactus",
        "Castle", "Guitar", "Feather", "Island", "Spider",
        "Fireworks", "Vampire", "Starfish", "Laptop", "Lightning",
        "Mermaid", "Telescope", "Rainbow", "Origami", "Dragonfly",
        "Coconut", "Moonlight", "Volcano", "Scissors", "Lighthouse",
        "Sailboat", "Pumpkin", "Galaxy", "Camping", "Pirate"
    };
    private static String[] level3 = {
        "Syzygy", "Onomatopoeia", "Quizzify", "Zephyr", "Pseudopseudohypoparathyroidism",
        "Cryptocurrency", "Labyrinthine", "Xylophone", "Epiphany", "Xenophobia",
        "Antidisestablishmentarianism", "Ephemeral", "Quixotic", "Incongruous", "Paradox",
        "Zucchini", "Serendipity", "Eccentric", "Mellifluous", "Belligerent",
        "Exacerbate", "Ambiguous", "Ineffable", "Resilience", "Esoteric",
        "Ubiquitous", "Insidious", "Magnanimous", "Capricious", "Labyrinth",
        "Quagmire", "Inscrutable", "Sanguine", "Gossamer", "Nebulous",
        "Opulent", "Vicarious", "Mellifluous", "Phantasmagoria", "Cacophony",
        "Intransigent", "Surreptitious", "Verisimilitude", "Ineffable", "Diaphanous",
        "Mellifluous", "Quintessential", "Serendipity", "Scintillating", "Euphoria"
    };;
    private static String[] activeWords = new String[50];
    
    public WordBank(difficulty DifficultyLevel){
        if(DifficultyLevel == difficulty.Easy){
            activeWords = level1;
        }
        else if(DifficultyLevel == difficulty.Medium){
            activeWords = level2;
        }
        else {
            activeWords = level3;
        }


    }

    public String randomString(){
        return activeWords[ThreadLocalRandom.current().nextInt(0,49)];
    }
   
}

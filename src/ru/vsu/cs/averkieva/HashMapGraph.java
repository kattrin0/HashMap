package ru.vsu.cs.averkieva;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HashMapGraph {
    private static <K, V> String toGraphviz(HashMap<K, V> map) {
        List<HashMap.Entry<K, V>>[] array = map.getArray();
        StringBuilder sb = new StringBuilder();
        sb.append("digraph HashMap {\n");
        sb.append("  node [shape=record, fontname=\"Arial\", fontsize=10];\n");
        sb.append("  rankdir=LR;\n"); //Left to Right
        sb.append("  nodesep=0.4;\n");
        sb.append("  ranksep=0.5;\n");
        sb.append("  edge [color=blue, arrowhead=vee];\n\n");

        // 1. Создаем бакеты
        for (int i = 0; i < array.length; i++) {
            sb.append(String.format("  bucket%d [label=\"Bucket %d\", shape=box, style=filled, fillcolor=lightgray];\n", i, i));
        }

        // 2. Обрабатываем каждый бакет
        for (int i = 0; i < array.length; i++) {
            if (array[i].isEmpty()) {
                // Для пустых бакетов
                sb.append(String.format("  null%d [label=\"null\", shape=plaintext];\n", i));
                sb.append(String.format("  bucket%d -> null%d [style=dashed];\n", i, i));
            } else {
                // Для непустых бакетов: создаем цепочку элементов
                for (int j = 0; j < array[i].size(); j++) {
                    HashMap.Entry<K, V> entry = array[i].get(j);
                    String nodeName = String.format("node_%d_%d", i, j);

                    sb.append(String.format("  %s [label=\"<f0> Entry |{hash: %d | key: %s | value: %s | <f1> next}\"];\n",
                            nodeName,
                            entry.key.hashCode(),
                            entry.key,
                            entry.value));

                    // Связь от бакета к первому элементу
                    if (j == 0) {
                        sb.append(String.format("  bucket%d -> %s:f0;\n", i, nodeName));
                    }

                    // Связи между элементами
                    if (j < array[i].size() - 1) {
                        String nextNode = String.format("node_%d_%d", i, j + 1);
                        sb.append(String.format("  %s:f1 -> %s:f0;\n", nodeName, nextNode));
                    } else {
                        // Для последнего элемента: стрелка на null
                        sb.append(String.format("  null%d [label=\"null\", shape=plaintext];\n", i));
                        sb.append(String.format("  %s:f1 -> null%d;\n", nodeName, i));
                    }
                }
            }
        }


        // Выравниваем бакеты
        sb.append("\n  { rank=same; ");
        for (int i = 0; i < array.length; i++) {
            sb.append("bucket").append(i).append("; ");
        }
        sb.append("}\n");

        sb.append("}\n");
        return sb.toString();
    }

    private static <K, V> void saveToDotFile(HashMap<K, V> map, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(toGraphviz(map));
            System.out.println("Граф успешно сохранен в файл: " + filename);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении файла: " + e.getMessage());
        }
    }


    public static <K, V> void saveAndVisualize(HashMap<K, V> map, String filename) {
        // сохраняем .dot файл
        saveToDotFile(map, filename);

        try {
            // конвертация в PNG
            String cmd = "\"C:\\Program Files\\Graphviz\\bin\\dot.exe\" -Tpng " +
                    filename + " -o " +
                    filename.replace(".dot", ".png");

            //выполнение команды
            Process process = Runtime.getRuntime().exec(cmd);
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Изображение успешно создано: " +
                        filename.replace(".dot", ".png"));
            } else {
                System.err.println("Ошибка при создании изображения. Код ошибки: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

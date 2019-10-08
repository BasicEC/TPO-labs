package lab2;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;

// Stole this class from my MathLab from second course ¯\_(ツ)_/¯
public class ChartCreater extends JFrame {
    public void createChart(double[] X, double[] Y) {
        XYDataset dataset = createDataset(X, Y);
        drawChart(dataset);
        pack();
        RefineryUtilities.centerFrameOnScreen(this);
        setVisible(true);
    }

    private void drawChart(XYDataset dataset) {
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);

        chartPanel.setPreferredSize(new Dimension(480, 512));
        setContentPane(chartPanel);
    }

    private JFreeChart createChart(XYDataset dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Ordinary Least Square",
                "X",
                "Y",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        XYPlot plot = chart.getXYPlot();
        plot.setAxisOffset(new RectangleInsets(1.0, 1.0, 1.0, 1.0));
        ValueAxis axis = plot.getDomainAxis();
        axis.setAxisLineVisible(false);

        XYSplineRenderer renderer = new XYSplineRenderer();
        renderer.setPrecision(7);
        renderer.setSeriesLinesVisible(1, false);
        renderer.setSeriesStroke(1, new BasicStroke(2.5f));
        renderer.setSeriesStroke(2, new BasicStroke(2.5f));

        plot.setRenderer(0, renderer);
        return chart;
    }

    private XYDataset createDataset(double[] X, double[] Y) {
        XYSeries first = new XYSeries("approximation");
        for (int i = 0; i < X.length; i++) {
            first.add(X[i], Y[i]);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(first);

        return dataset;
    }
}

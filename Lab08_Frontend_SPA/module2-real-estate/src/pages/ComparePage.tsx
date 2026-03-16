import { useEffect, useState } from "react";
import type { Property } from "@/types/property";
import { loadCompare, saveCompare } from "@/lib/compare";
import { Button } from "@/components/ui/button";

export function ComparePage() {

  const [properties, setProperties] = useState<Property[]>([]);

  useEffect(() => {
    setProperties(loadCompare());
  }, []);

  const remove = (id: string) => {
    const updated = properties.filter(p => p.id !== id);
    setProperties(updated);
    saveCompare(updated);
  };

  if (properties.length === 0) {
    return (
      <div className="container py-12 text-center">
        No hay propiedades seleccionadas
      </div>
    );
  }

  const minPrice = Math.min(...properties.map(p => p.price));
  const maxArea = Math.max(...properties.map(p => p.area));

  return (
    <div className="container py-8">

      <h1 className="text-2xl font-bold mb-6">
        Comparación de propiedades
      </h1>

      <table className="w-full border">

        <thead>
          <tr>
            <th>Métrica</th>
            {properties.map(p => (
              <th key={p.id}>{p.title}</th>
            ))}
          </tr>
        </thead>

        <tbody>

          <tr>
            <td>Precio</td>
            {properties.map(p => (
              <td
                key={p.id}
                className={p.price === minPrice ? "font-bold text-green-600" : ""}
              >
                ${p.price}
              </td>
            ))}
          </tr>

          <tr>
            <td>Habitaciones</td>
            {properties.map(p => (
              <td key={p.id}>{p.bedrooms}</td>
            ))}
          </tr>

          <tr>
            <td>Baños</td>
            {properties.map(p => (
              <td key={p.id}>{p.bathrooms}</td>
            ))}
          </tr>

          <tr>
            <td>Área</td>
            {properties.map(p => (
              <td
                key={p.id}
                className={p.area === maxArea ? "font-bold text-blue-600" : ""}
              >
                {p.area}
              </td>
            ))}
          </tr>

          <tr>
            <td></td>
            {properties.map(p => (
              <td key={p.id}>
                <Button
                  size="sm"
                  variant="destructive"
                  onClick={() => remove(p.id)}
                >
                  Remover
                </Button>
              </td>
            ))}
          </tr>

        </tbody>

      </table>
    </div>
  );
}
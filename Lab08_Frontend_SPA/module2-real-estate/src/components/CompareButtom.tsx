import { useEffect, useState } from "react";
import { Button } from "@/components/ui/button";
import { Scale } from "lucide-react";
import type { Property } from "@/types/property";
import { loadCompare, toggleCompare } from "@/lib/compare";

interface Props {
  property: Property;
}

export function CompareButton({ property }: Props) {

  const [selected, setSelected] = useState(false);

  useEffect(() => {
    const list = loadCompare();
    setSelected(list.some(p => p.id === property.id));
  }, [property.id]);

  const handleClick = () => {
    const updated = toggleCompare(property);
    setSelected(updated.some(p => p.id === property.id));
  };

  return (
    <Button
      size="icon"
      variant={selected ? "secondary" : "outline"}
      onClick={handleClick}
    >
      <Scale className="h-4 w-4" />
    </Button>
  );
}
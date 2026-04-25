ALTER TABLE public.obras_documentos
    ADD COLUMN IF NOT EXISTS tenant_id VARCHAR(50);

UPDATE public.obras_documentos od
SET tenant_id = o.tenant_id
FROM public.obra o
WHERE o.id = od.id_obra
  AND od.tenant_id IS NULL;

ALTER TABLE public.obras_documentos
    ALTER COLUMN tenant_id SET NOT NULL;
